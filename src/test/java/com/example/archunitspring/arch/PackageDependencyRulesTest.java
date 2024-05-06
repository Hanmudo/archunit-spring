package com.example.archunitspring.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.net.URL;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.Configuration.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.adhereToPlantUmlDiagram;

public class PackageDependencyRulesTest {

    @Test
    public void services_should_be_postfixed() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.archunitspring");
        classes()
                .that().resideInAPackage("..services..")
                .and().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("ServiceImpl")
                .check(importedClasses);
    }

    @Test
    public void test() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.archunitspring");
        noClasses().that().resideOutsideOfPackage("..services..")
                .should().accessClassesThat().areAssignableTo(Service.class)
                .as("Only Service Implementations may use the " + Service.class.getSimpleName())
                .check(importedClasses);
    }

//    @Test
//    public void test_plantuml() {
//        final JavaClasses classes = new ClassFileImporter().importPackages("com.example.archunitspring");
//        final URL plantUmlDiagram = PackageDependencyRulesTest.class.getResource("basic.puml");
//
//        classes().should(adhereToPlantUmlDiagram(plantUmlDiagram, consideringOnlyDependenciesInDiagram()))
//                .check(classes);
//    }
}
