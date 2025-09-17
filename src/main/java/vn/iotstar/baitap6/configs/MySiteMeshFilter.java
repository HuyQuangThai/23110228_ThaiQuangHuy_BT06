package vn.iotstar.baitap6.configs;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.builder.SiteMeshFilterBuilder;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/web.jsp")
                .addDecoratorPath("/admin/*", "/admin.jsp")
                .addExcludedPath("/login")
                .addExcludedPath("/api/*");
    }
}
