package com.digitalworks.core.models;

import com.adobe.cq.wcm.core.components.models.Title;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {Title.class}, resourceType = "digitalworks/components/content/pageheading", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageHeading implements Title {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageHeading.class);

    @Inject
    private Resource resource;

    @ValueMapValue
    private String onPageTitle;

    @ValueMapValue
    private String pageHeadingType;

    @ValueMapValue
    private String analyticsID;

    @ValueMapValue
    private String pageTitleCheckBox;


    public String getOnPageTitle() {
        return onPageTitle;
    }

    public String getPageHeadingType() {
        return pageHeadingType;
    }

    public String getAnalyticsID() {
        return analyticsID;
    }

    public String getPageTitleCheckBox() {
        if(!this.pageTitleCheckBox.equalsIgnoreCase("true")) return "false";
        return pageTitleCheckBox;
    }
}
