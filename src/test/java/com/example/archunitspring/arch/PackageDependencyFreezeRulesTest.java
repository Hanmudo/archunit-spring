package com.example.archunitspring.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

public class PackageDependencyFreezeRulesTest {

    @Test
    public void services_should_be_postfixed_correctly() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.archunitspring");
        freeze(classes()
                .that().resideInAPackage("..services..")
                .and().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("ServiceImple"))
                .check(importedClasses);
    }

}
