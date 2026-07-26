package com.peruch.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.peruch.hexagonal")
public class NamingConventionTests {

    @ArchTest
    public static final ArchRule consumer_class_reside_only_in_consumer_package = classes().that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer")
            .as("consumer classes should reside in adapters.in.consumer package");

    @ArchTest
    public static final ArchRule mapper_classes_reside_only_in_mapper_packages = classes().that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.consumer.mapper",
                    "..adapters.in.controller.mapper",
                    "..adapters.out.client.mapper",
                    "..adapters.out.repository.mapper")
            .as("mapper classes should reside in adapters.in.consumer.mapper, adapters.in.controller.mapper, adapters.out.client.mapper, adapters.out.repository.mapper");

    @ArchTest
    public static final ArchRule controller_class_reside_only_in_controller_package = classes().that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.in.controller")
            .as("controller classes should reside in adapters.in.controller");

    @ArchTest
    public static final ArchRule adapter_classes_reside_only_in_adapter_package = classes().that()
            .haveNameMatching(".*Adapter")
            .should()
            .resideInAPackage("..adapters.out")
            .as("adapters classes should reside in adapters");

    @ArchTest
    public static final ArchRule repository_class_reside_only_in_repository_package = classes().that()
            .haveNameMatching(".*Repository")
            .should()
            .resideInAPackage("..repository")
            .as("repository classes should reside in repository package");

    @ArchTest
    public static final ArchRule should_have_suffix_consumer = classes().that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer")
            .as("consumer class should have Consumer suffix");

    @ArchTest
    public static final ArchRule should_have_suffix_mapper = classes().that()
            .resideInAPackage("..mapper")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.consumer.mapper",
                    "..adapters.in.controller.mapper",
                    "..adapters.out.client.mapper",
                    "..adapters.out.repository.mapper")
            .as("mapper classes should have Mapper(or MapperImpl) suffix");

}
