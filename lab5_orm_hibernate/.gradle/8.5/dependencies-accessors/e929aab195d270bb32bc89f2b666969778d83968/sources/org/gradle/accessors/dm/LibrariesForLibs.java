package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JavaxLibraryAccessors laccForJavaxLibraryAccessors = new JavaxLibraryAccessors(owner);
    private final MysqlLibraryAccessors laccForMysqlLibraryAccessors = new MysqlLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Returns the group of libraries at javax
     */
    public JavaxLibraryAccessors getJavax() {
        return laccForJavaxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at mysql
     */
    public MysqlLibraryAccessors getMysql() {
        return laccForMysqlLibraryAccessors;
    }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComSunLibraryAccessors laccForComSunLibraryAccessors = new ComSunLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.sun
         */
        public ComSunLibraryAccessors getSun() {
            return laccForComSunLibraryAccessors;
        }

    }

    public static class ComSunLibraryAccessors extends SubDependencyFactory {
        private final ComSunXmlLibraryAccessors laccForComSunXmlLibraryAccessors = new ComSunXmlLibraryAccessors(owner);

        public ComSunLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.sun.xml
         */
        public ComSunXmlLibraryAccessors getXml() {
            return laccForComSunXmlLibraryAccessors;
        }

    }

    public static class ComSunXmlLibraryAccessors extends SubDependencyFactory {
        private final ComSunXmlBindLibraryAccessors laccForComSunXmlBindLibraryAccessors = new ComSunXmlBindLibraryAccessors(owner);

        public ComSunXmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.sun.xml.bind
         */
        public ComSunXmlBindLibraryAccessors getBind() {
            return laccForComSunXmlBindLibraryAccessors;
        }

    }

    public static class ComSunXmlBindLibraryAccessors extends SubDependencyFactory {
        private final ComSunXmlBindJaxbLibraryAccessors laccForComSunXmlBindJaxbLibraryAccessors = new ComSunXmlBindJaxbLibraryAccessors(owner);

        public ComSunXmlBindLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.sun.xml.bind.jaxb
         */
        public ComSunXmlBindJaxbLibraryAccessors getJaxb() {
            return laccForComSunXmlBindJaxbLibraryAccessors;
        }

    }

    public static class ComSunXmlBindJaxbLibraryAccessors extends SubDependencyFactory {

        public ComSunXmlBindJaxbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for impl (com.sun.xml.bind:jaxb-impl)
         * with versionRef 'com.sun.xml.bind.jaxb.impl'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getImpl() {
                return create("com.sun.xml.bind.jaxb.impl");
        }

    }

    public static class JavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxXmlLibraryAccessors laccForJavaxXmlLibraryAccessors = new JavaxXmlLibraryAccessors(owner);

        public JavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.xml
         */
        public JavaxXmlLibraryAccessors getXml() {
            return laccForJavaxXmlLibraryAccessors;
        }

    }

    public static class JavaxXmlLibraryAccessors extends SubDependencyFactory {
        private final JavaxXmlBindLibraryAccessors laccForJavaxXmlBindLibraryAccessors = new JavaxXmlBindLibraryAccessors(owner);

        public JavaxXmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.xml.bind
         */
        public JavaxXmlBindLibraryAccessors getBind() {
            return laccForJavaxXmlBindLibraryAccessors;
        }

    }

    public static class JavaxXmlBindLibraryAccessors extends SubDependencyFactory {
        private final JavaxXmlBindJaxbLibraryAccessors laccForJavaxXmlBindJaxbLibraryAccessors = new JavaxXmlBindJaxbLibraryAccessors(owner);

        public JavaxXmlBindLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.xml.bind.jaxb
         */
        public JavaxXmlBindJaxbLibraryAccessors getJaxb() {
            return laccForJavaxXmlBindJaxbLibraryAccessors;
        }

    }

    public static class JavaxXmlBindJaxbLibraryAccessors extends SubDependencyFactory {

        public JavaxXmlBindJaxbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (javax.xml.bind:jaxb-api)
         * with versionRef 'javax.xml.bind.jaxb.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("javax.xml.bind.jaxb.api");
        }

    }

    public static class MysqlLibraryAccessors extends SubDependencyFactory {
        private final MysqlMysqlLibraryAccessors laccForMysqlMysqlLibraryAccessors = new MysqlMysqlLibraryAccessors(owner);

        public MysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at mysql.mysql
         */
        public MysqlMysqlLibraryAccessors getMysql() {
            return laccForMysqlMysqlLibraryAccessors;
        }

    }

    public static class MysqlMysqlLibraryAccessors extends SubDependencyFactory {
        private final MysqlMysqlConnectorLibraryAccessors laccForMysqlMysqlConnectorLibraryAccessors = new MysqlMysqlConnectorLibraryAccessors(owner);

        public MysqlMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at mysql.mysql.connector
         */
        public MysqlMysqlConnectorLibraryAccessors getConnector() {
            return laccForMysqlMysqlConnectorLibraryAccessors;
        }

    }

    public static class MysqlMysqlConnectorLibraryAccessors extends SubDependencyFactory {

        public MysqlMysqlConnectorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for java (mysql:mysql-connector-java)
         * with versionRef 'mysql.mysql.connector.java'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJava() {
                return create("mysql.mysql.connector.java");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateLibraryAccessors laccForOrgHibernateLibraryAccessors = new OrgHibernateLibraryAccessors(owner);
        private final OrgJunitLibraryAccessors laccForOrgJunitLibraryAccessors = new OrgJunitLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.hibernate
         */
        public OrgHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.junit
         */
        public OrgJunitLibraryAccessors getJunit() {
            return laccForOrgJunitLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.mockito
         */
        public OrgMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoLibraryAccessors;
        }

    }

    public static class OrgHibernateLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateHibernateLibraryAccessors laccForOrgHibernateHibernateLibraryAccessors = new OrgHibernateHibernateLibraryAccessors(owner);

        public OrgHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.hibernate.hibernate
         */
        public OrgHibernateHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateHibernateLibraryAccessors;
        }

    }

    public static class OrgHibernateHibernateLibraryAccessors extends SubDependencyFactory {

        public OrgHibernateHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.hibernate:hibernate-core)
         * with versionRef 'org.hibernate.hibernate.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("org.hibernate.hibernate.core");
        }

            /**
             * Creates a dependency provider for entitymanager (org.hibernate:hibernate-entitymanager)
         * with versionRef 'org.hibernate.hibernate.entitymanager'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEntitymanager() {
                return create("org.hibernate.hibernate.entitymanager");
        }

    }

    public static class OrgJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterLibraryAccessors laccForOrgJunitJupiterLibraryAccessors = new OrgJunitJupiterLibraryAccessors(owner);
        private final OrgJunitPlatformLibraryAccessors laccForOrgJunitPlatformLibraryAccessors = new OrgJunitPlatformLibraryAccessors(owner);

        public OrgJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.jupiter
         */
        public OrgJunitJupiterLibraryAccessors getJupiter() {
            return laccForOrgJunitJupiterLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.junit.platform
         */
        public OrgJunitPlatformLibraryAccessors getPlatform() {
            return laccForOrgJunitPlatformLibraryAccessors;
        }

    }

    public static class OrgJunitJupiterLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterJunitLibraryAccessors laccForOrgJunitJupiterJunitLibraryAccessors = new OrgJunitJupiterJunitLibraryAccessors(owner);

        public OrgJunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.jupiter.junit
         */
        public OrgJunitJupiterJunitLibraryAccessors getJunit() {
            return laccForOrgJunitJupiterJunitLibraryAccessors;
        }

    }

    public static class OrgJunitJupiterJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterJunitJupiterLibraryAccessors laccForOrgJunitJupiterJunitJupiterLibraryAccessors = new OrgJunitJupiterJunitJupiterLibraryAccessors(owner);

        public OrgJunitJupiterJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.jupiter.junit.jupiter
         */
        public OrgJunitJupiterJunitJupiterLibraryAccessors getJupiter() {
            return laccForOrgJunitJupiterJunitJupiterLibraryAccessors;
        }

    }

    public static class OrgJunitJupiterJunitJupiterLibraryAccessors extends SubDependencyFactory {

        public OrgJunitJupiterJunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.junit.jupiter:junit-jupiter-api)
         * with versionRef 'org.junit.jupiter.junit.jupiter.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("org.junit.jupiter.junit.jupiter.api");
        }

            /**
             * Creates a dependency provider for engine (org.junit.jupiter:junit-jupiter-engine)
         * with versionRef 'org.junit.jupiter.junit.jupiter.engine'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEngine() {
                return create("org.junit.jupiter.junit.jupiter.engine");
        }

    }

    public static class OrgJunitPlatformLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitPlatformJunitLibraryAccessors laccForOrgJunitPlatformJunitLibraryAccessors = new OrgJunitPlatformJunitLibraryAccessors(owner);

        public OrgJunitPlatformLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.platform.junit
         */
        public OrgJunitPlatformJunitLibraryAccessors getJunit() {
            return laccForOrgJunitPlatformJunitLibraryAccessors;
        }

    }

    public static class OrgJunitPlatformJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitPlatformJunitPlatformLibraryAccessors laccForOrgJunitPlatformJunitPlatformLibraryAccessors = new OrgJunitPlatformJunitPlatformLibraryAccessors(owner);

        public OrgJunitPlatformJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.junit.platform.junit.platform
         */
        public OrgJunitPlatformJunitPlatformLibraryAccessors getPlatform() {
            return laccForOrgJunitPlatformJunitPlatformLibraryAccessors;
        }

    }

    public static class OrgJunitPlatformJunitPlatformLibraryAccessors extends SubDependencyFactory {

        public OrgJunitPlatformJunitPlatformLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for launcher (org.junit.platform:junit-platform-launcher)
         * with versionRef 'org.junit.platform.junit.platform.launcher'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLauncher() {
                return create("org.junit.platform.junit.platform.launcher");
        }

    }

    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoMockitoLibraryAccessors laccForOrgMockitoMockitoLibraryAccessors = new OrgMockitoMockitoLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mockito.mockito
         */
        public OrgMockitoMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoMockitoLibraryAccessors;
        }

    }

    public static class OrgMockitoMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoMockitoJunitLibraryAccessors laccForOrgMockitoMockitoJunitLibraryAccessors = new OrgMockitoMockitoJunitLibraryAccessors(owner);

        public OrgMockitoMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.mockito:mockito-core)
         * with versionRef 'org.mockito.mockito.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("org.mockito.mockito.core");
        }

        /**
         * Returns the group of libraries at org.mockito.mockito.junit
         */
        public OrgMockitoMockitoJunitLibraryAccessors getJunit() {
            return laccForOrgMockitoMockitoJunitLibraryAccessors;
        }

    }

    public static class OrgMockitoMockitoJunitLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoMockitoJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jupiter (org.mockito:mockito-junit-jupiter)
         * with versionRef 'org.mockito.mockito.junit.jupiter'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJupiter() {
                return create("org.mockito.mockito.junit.jupiter");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final MysqlVersionAccessors vaccForMysqlVersionAccessors = new MysqlVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax
         */
        public JavaxVersionAccessors getJavax() {
            return vaccForJavaxVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.mysql
         */
        public MysqlVersionAccessors getMysql() {
            return vaccForMysqlVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComSunVersionAccessors vaccForComSunVersionAccessors = new ComSunVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.sun
         */
        public ComSunVersionAccessors getSun() {
            return vaccForComSunVersionAccessors;
        }

    }

    public static class ComSunVersionAccessors extends VersionFactory  {

        private final ComSunXmlVersionAccessors vaccForComSunXmlVersionAccessors = new ComSunXmlVersionAccessors(providers, config);
        public ComSunVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.sun.xml
         */
        public ComSunXmlVersionAccessors getXml() {
            return vaccForComSunXmlVersionAccessors;
        }

    }

    public static class ComSunXmlVersionAccessors extends VersionFactory  {

        private final ComSunXmlBindVersionAccessors vaccForComSunXmlBindVersionAccessors = new ComSunXmlBindVersionAccessors(providers, config);
        public ComSunXmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.sun.xml.bind
         */
        public ComSunXmlBindVersionAccessors getBind() {
            return vaccForComSunXmlBindVersionAccessors;
        }

    }

    public static class ComSunXmlBindVersionAccessors extends VersionFactory  {

        private final ComSunXmlBindJaxbVersionAccessors vaccForComSunXmlBindJaxbVersionAccessors = new ComSunXmlBindJaxbVersionAccessors(providers, config);
        public ComSunXmlBindVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.sun.xml.bind.jaxb
         */
        public ComSunXmlBindJaxbVersionAccessors getJaxb() {
            return vaccForComSunXmlBindJaxbVersionAccessors;
        }

    }

    public static class ComSunXmlBindJaxbVersionAccessors extends VersionFactory  {

        public ComSunXmlBindJaxbVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.sun.xml.bind.jaxb.impl (2.3.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getImpl() { return getVersion("com.sun.xml.bind.jaxb.impl"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        private final JavaxXmlVersionAccessors vaccForJavaxXmlVersionAccessors = new JavaxXmlVersionAccessors(providers, config);
        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.xml
         */
        public JavaxXmlVersionAccessors getXml() {
            return vaccForJavaxXmlVersionAccessors;
        }

    }

    public static class JavaxXmlVersionAccessors extends VersionFactory  {

        private final JavaxXmlBindVersionAccessors vaccForJavaxXmlBindVersionAccessors = new JavaxXmlBindVersionAccessors(providers, config);
        public JavaxXmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.xml.bind
         */
        public JavaxXmlBindVersionAccessors getBind() {
            return vaccForJavaxXmlBindVersionAccessors;
        }

    }

    public static class JavaxXmlBindVersionAccessors extends VersionFactory  {

        private final JavaxXmlBindJaxbVersionAccessors vaccForJavaxXmlBindJaxbVersionAccessors = new JavaxXmlBindJaxbVersionAccessors(providers, config);
        public JavaxXmlBindVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.xml.bind.jaxb
         */
        public JavaxXmlBindJaxbVersionAccessors getJaxb() {
            return vaccForJavaxXmlBindJaxbVersionAccessors;
        }

    }

    public static class JavaxXmlBindJaxbVersionAccessors extends VersionFactory  {

        public JavaxXmlBindJaxbVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.xml.bind.jaxb.api (2.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("javax.xml.bind.jaxb.api"); }

    }

    public static class MysqlVersionAccessors extends VersionFactory  {

        private final MysqlMysqlVersionAccessors vaccForMysqlMysqlVersionAccessors = new MysqlMysqlVersionAccessors(providers, config);
        public MysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.mysql.mysql
         */
        public MysqlMysqlVersionAccessors getMysql() {
            return vaccForMysqlMysqlVersionAccessors;
        }

    }

    public static class MysqlMysqlVersionAccessors extends VersionFactory  {

        private final MysqlMysqlConnectorVersionAccessors vaccForMysqlMysqlConnectorVersionAccessors = new MysqlMysqlConnectorVersionAccessors(providers, config);
        public MysqlMysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.mysql.mysql.connector
         */
        public MysqlMysqlConnectorVersionAccessors getConnector() {
            return vaccForMysqlMysqlConnectorVersionAccessors;
        }

    }

    public static class MysqlMysqlConnectorVersionAccessors extends VersionFactory  {

        public MysqlMysqlConnectorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: mysql.mysql.connector.java (8.0.33)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJava() { return getVersion("mysql.mysql.connector.java"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgHibernateVersionAccessors vaccForOrgHibernateVersionAccessors = new OrgHibernateVersionAccessors(providers, config);
        private final OrgJunitVersionAccessors vaccForOrgJunitVersionAccessors = new OrgJunitVersionAccessors(providers, config);
        private final OrgMockitoVersionAccessors vaccForOrgMockitoVersionAccessors = new OrgMockitoVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.hibernate
         */
        public OrgHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.junit
         */
        public OrgJunitVersionAccessors getJunit() {
            return vaccForOrgJunitVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.mockito
         */
        public OrgMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoVersionAccessors;
        }

    }

    public static class OrgHibernateVersionAccessors extends VersionFactory  {

        private final OrgHibernateHibernateVersionAccessors vaccForOrgHibernateHibernateVersionAccessors = new OrgHibernateHibernateVersionAccessors(providers, config);
        public OrgHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.hibernate.hibernate
         */
        public OrgHibernateHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateHibernateVersionAccessors;
        }

    }

    public static class OrgHibernateHibernateVersionAccessors extends VersionFactory  {

        public OrgHibernateHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.hibernate.hibernate.core (6.1.7.Final)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("org.hibernate.hibernate.core"); }

            /**
             * Returns the version associated to this alias: org.hibernate.hibernate.entitymanager (5.6.15.Final)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEntitymanager() { return getVersion("org.hibernate.hibernate.entitymanager"); }

    }

    public static class OrgJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitJupiterVersionAccessors vaccForOrgJunitJupiterVersionAccessors = new OrgJunitJupiterVersionAccessors(providers, config);
        private final OrgJunitPlatformVersionAccessors vaccForOrgJunitPlatformVersionAccessors = new OrgJunitPlatformVersionAccessors(providers, config);
        public OrgJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.junit.jupiter
         */
        public OrgJunitJupiterVersionAccessors getJupiter() {
            return vaccForOrgJunitJupiterVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.junit.platform
         */
        public OrgJunitPlatformVersionAccessors getPlatform() {
            return vaccForOrgJunitPlatformVersionAccessors;
        }

    }

    public static class OrgJunitJupiterVersionAccessors extends VersionFactory  {

        private final OrgJunitJupiterJunitVersionAccessors vaccForOrgJunitJupiterJunitVersionAccessors = new OrgJunitJupiterJunitVersionAccessors(providers, config);
        public OrgJunitJupiterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.junit.jupiter.junit
         */
        public OrgJunitJupiterJunitVersionAccessors getJunit() {
            return vaccForOrgJunitJupiterJunitVersionAccessors;
        }

    }

    public static class OrgJunitJupiterJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitJupiterJunitJupiterVersionAccessors vaccForOrgJunitJupiterJunitJupiterVersionAccessors = new OrgJunitJupiterJunitJupiterVersionAccessors(providers, config);
        public OrgJunitJupiterJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.junit.jupiter.junit.jupiter
         */
        public OrgJunitJupiterJunitJupiterVersionAccessors getJupiter() {
            return vaccForOrgJunitJupiterJunitJupiterVersionAccessors;
        }

    }

    public static class OrgJunitJupiterJunitJupiterVersionAccessors extends VersionFactory  {

        public OrgJunitJupiterJunitJupiterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.junit.jupiter.junit.jupiter.api (5.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("org.junit.jupiter.junit.jupiter.api"); }

            /**
             * Returns the version associated to this alias: org.junit.jupiter.junit.jupiter.engine (5.8.0-M1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEngine() { return getVersion("org.junit.jupiter.junit.jupiter.engine"); }

    }

    public static class OrgJunitPlatformVersionAccessors extends VersionFactory  {

        private final OrgJunitPlatformJunitVersionAccessors vaccForOrgJunitPlatformJunitVersionAccessors = new OrgJunitPlatformJunitVersionAccessors(providers, config);
        public OrgJunitPlatformVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.junit.platform.junit
         */
        public OrgJunitPlatformJunitVersionAccessors getJunit() {
            return vaccForOrgJunitPlatformJunitVersionAccessors;
        }

    }

    public static class OrgJunitPlatformJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitPlatformJunitPlatformVersionAccessors vaccForOrgJunitPlatformJunitPlatformVersionAccessors = new OrgJunitPlatformJunitPlatformVersionAccessors(providers, config);
        public OrgJunitPlatformJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.junit.platform.junit.platform
         */
        public OrgJunitPlatformJunitPlatformVersionAccessors getPlatform() {
            return vaccForOrgJunitPlatformJunitPlatformVersionAccessors;
        }

    }

    public static class OrgJunitPlatformJunitPlatformVersionAccessors extends VersionFactory  {

        public OrgJunitPlatformJunitPlatformVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.junit.platform.junit.platform.launcher (1.8.0-M1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLauncher() { return getVersion("org.junit.platform.junit.platform.launcher"); }

    }

    public static class OrgMockitoVersionAccessors extends VersionFactory  {

        private final OrgMockitoMockitoVersionAccessors vaccForOrgMockitoMockitoVersionAccessors = new OrgMockitoMockitoVersionAccessors(providers, config);
        public OrgMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mockito.mockito
         */
        public OrgMockitoMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoMockitoVersionAccessors;
        }

    }

    public static class OrgMockitoMockitoVersionAccessors extends VersionFactory  {

        private final OrgMockitoMockitoJunitVersionAccessors vaccForOrgMockitoMockitoJunitVersionAccessors = new OrgMockitoMockitoJunitVersionAccessors(providers, config);
        public OrgMockitoMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.mockito.mockito.core (5.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("org.mockito.mockito.core"); }

        /**
         * Returns the group of versions at versions.org.mockito.mockito.junit
         */
        public OrgMockitoMockitoJunitVersionAccessors getJunit() {
            return vaccForOrgMockitoMockitoJunitVersionAccessors;
        }

    }

    public static class OrgMockitoMockitoJunitVersionAccessors extends VersionFactory  {

        public OrgMockitoMockitoJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.mockito.mockito.junit.jupiter (2.23.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJupiter() { return getVersion("org.mockito.mockito.junit.jupiter"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
