package com.example.archunitspring.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.net.URL;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.Configuration.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.adhereToPlantUmlDiagram;

@AnalyzeClasses(packages = "com.example.archunitspring", importOptions = {ImportOption.DoNotIncludeTests.class})
public class PlantUMLRulesTest {
    private static final URL plantUmlDiagram = PlantUMLRulesTest.class.getResource("basic.puml");
    private static final URL plantUmlBDiagram = PlantUMLRulesTest.class.getResource("morebasic.puml");

    @ArchTest
    static final ArchRule classes_should_adhere_to_plantuml_considering_only_dependencies_in_diagram =
            classes().should(adhereToPlantUmlDiagram(plantUmlDiagram, consideringOnlyDependenciesInDiagram()));

    @ArchTest
    static final ArchRule classes_should_adhere_to_plantuml_considering_only_dependencies_in_Bdiagram =
            classes().should(adhereToPlantUmlDiagram(plantUmlBDiagram, consideringOnlyDependenciesInDiagram()));
}
