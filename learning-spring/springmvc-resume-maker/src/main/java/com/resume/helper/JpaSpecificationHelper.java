package com.resume.helper;

import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.Set;

public class JpaSpecificationHelper<E> {
    public static <E> Specification<E> searchQuery(String keyword) {
        return new Specification<E>() {
            @Override
            public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Set<Predicate> likePredicates = new HashSet<>();

                for (SingularAttribute<?, ?> attribute : root.getModel().getDeclaredSingularAttributes()) {
                    if (attribute.getJavaType().equals(String.class)) {
                        likePredicates.add(getLikePredicate(criteriaBuilder, root, attribute, keyword));
                    }
                }

                return criteriaBuilder.or(likePredicates.toArray(new Predicate[0]));
            }
        };
    }

    private static <E> Predicate getLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName());

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }
}
