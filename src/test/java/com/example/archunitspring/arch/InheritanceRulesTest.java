package com.example.archunitspring.arch;

import com.example.archunitspring.application.interfaces.TicketService;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class InheritanceRulesTest {
    @Test
    public void service_classes_should_implement_interfaces() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.archunitspring");
        classes()
                .that().implement(TicketService.class)
                .should().haveSimpleNameEndingWith("ServiceImpl")
                .check(importedClasses);
    }
}
