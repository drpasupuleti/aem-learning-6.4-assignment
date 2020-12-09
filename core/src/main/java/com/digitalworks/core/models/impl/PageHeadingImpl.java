package com.digitalworks.core.models.impl;

import com.adobe.cq.wcm.core.components.models.Title;
import com.digitalworks.core.models.PageHeading;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {PageHeading.class, Title.class}, resourceType = "digitalworks/components/content/pageheading", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageHeadingImpl implements PageHeading, Title {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageHeadingImpl.class);

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


    @Override
    public String getOnPageTitle() {
        return onPageTitle;
    }

    @Override
    public String getPageHeadingType() {
        return pageHeadingType;
    }

    @Override
    public String getAnalyticsID() {
        return analyticsID;
    }

    @Override
    public String getPageTitleCheckBox() {
        if (!this.pageTitleCheckBox.equalsIgnoreCase("true")) return "false";
        return pageTitleCheckBox;
    }
}
