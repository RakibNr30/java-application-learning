package com.resume.helper;

import com.resume.entity.cms.Interest;
import com.resume.entity.cms.Language;
import com.resume.entity.cms.Skill;
import com.resume.entity.cms.SocialAccount;
import com.resume.entity.ums.User;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.Set;

public class JpaSpecificationHelper {
    public static <E> Specification<E> searchQuery(String keyword) {
        return (root, query, criteriaBuilder) -> {
            Set<Predicate> likePredicates = new HashSet<>();

            for (SingularAttribute<?, ?> attribute : root.getModel().getDeclaredSingularAttributes()) {
                if (attribute.getJavaType().equals(String.class)) {
                    likePredicates.add(getLikePredicate(criteriaBuilder, root, attribute, keyword));
                }
                if (attribute.getJavaType().equals(User.class)) {
                    likePredicates.add(getUserLikePredicate(criteriaBuilder, root, attribute, keyword));
                }
                if (attribute.getJavaType().equals(Interest.class)) {
                    likePredicates.add(getInterestLikePredicate(criteriaBuilder, root, attribute, keyword));
                }
                if (attribute.getJavaType().equals(Language.class)) {
                    likePredicates.add(getLanguageLikePredicate(criteriaBuilder, root, attribute, keyword));
                }
                if (attribute.getJavaType().equals(Skill.class)) {
                    likePredicates.add(getSkillLikePredicate(criteriaBuilder, root, attribute, keyword));
                }
                if (attribute.getJavaType().equals(SocialAccount.class)) {
                    likePredicates.add(getSocialAccountLikePredicate(criteriaBuilder, root, attribute, keyword));
                }
            }

            return criteriaBuilder.or(likePredicates.toArray(new Predicate[0]));
        };
    }

    private static <E> Predicate getLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName());

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }

    private static <E> Predicate getUserLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName()).get("name");

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }

    private static <E> Predicate getInterestLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName()).get("name");

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }

    private static <E> Predicate getLanguageLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName()).get("name");

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }

    private static <E> Predicate getSkillLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName()).get("name");

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }

    private static <E> Predicate getSocialAccountLikePredicate(CriteriaBuilder criteriaBuilder, Root<E> root, SingularAttribute<?, ?> attribute, String keyword) {
        Path<String> attributePath = root.get(attribute.getName()).get("name");

        return criteriaBuilder.like(criteriaBuilder.lower(attributePath), "%" + keyword.trim().toLowerCase() + "%");
    }
}
