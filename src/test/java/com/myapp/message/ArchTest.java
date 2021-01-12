package com.myapp.message;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.myapp.message");

        noClasses()
            .that()
                .resideInAnyPackage("com.myapp.message.service..")
            .or()
                .resideInAnyPackage("com.myapp.message.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.myapp.message.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
