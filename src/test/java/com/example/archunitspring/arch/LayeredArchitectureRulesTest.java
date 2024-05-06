package com.example.archunitspring.arch;

import com.example.archunitspring.ArchunitSpringApplication;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.example.archunitspring", importOptions = {ImportOption.DoNotIncludeTests.class})
public class LayeredArchitectureRulesTest {
    @ArchTest
    static final ArchRule testLayeredArchitecture =
            layeredArchitecture().consideringAllDependencies()
                    // Define layers
                    .layer("Presentation").definedBy("..presentation..")
                    .layer("Infrastructure").definedBy("..infrastructure..")
                    .layer("Application").definedBy("..application..")
                    // Add constraints
                    .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Infrastructure").mayOnlyBeAccessedByLayers("Application")
                    .whereLayer("Application").mayOnlyBeAccessedByLayers("Presentation", "Infrastructure");

}
