<c:if test="${not empty notifierStatus}">
    <div class="alert alert-${notifierBg} alert-dismissible fade show" role="alert">
        <strong>${notifierTitle}!</strong> ${notifierMessage}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>