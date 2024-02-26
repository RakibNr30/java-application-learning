document.addEventListener('DOMContentLoaded', () => {
    const requiredElements = document.querySelectorAll('[required]');

    requiredElements.forEach(function (requiredElement) {
        const label = document.querySelector('label[for="' + requiredElement.id + '"]');
        label.innerHTML += '<span style="color: red;"> *</span>';
    });

    const toggleSection = (sectionId, btnId) => {
        const section = document.getElementById(sectionId);
        const btn = document.getElementById(btnId);
        const isHidden = section.classList.toggle("d-none");
        btn.innerHTML = isHidden ? "<i class=\"fa fa-plus\"></i> Open" : "<i class=\"fa fa-times\"></i> Close";
        btn.classList.toggle("btn-primary", isHidden);
        btn.classList.toggle("btn-danger", !isHidden);
    }

    const educationBtn = document.getElementById("education-btn");
    educationBtn.addEventListener("click", () => {
        toggleSection("education-form", "education-btn");
    });

    /*const experienceBtn = document.getElementById("experience-btn");
    experienceBtn.addEventListener("click", () => {
        toggleSection("experience-form", "experience-btn");
    });*/
});