package com.example.archunitspring.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.example.archunitspring", importOptions = {ImportOption.DoNotIncludeTests.class})
public class AntiPatternRulesTest {
    @ArchTest
    static final ArchRule domain_classes_should_not_depend_on_each_other =
            SlicesRuleDefinition.slices()
                    .matching("com.example.(*spring).application.models")
                    .should().notDependOnEachOther();
}
