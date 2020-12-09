package com.digitalworks.core.models.impl;

import com.adobe.cq.wcm.core.components.models.Title;
import com.digitalworks.core.models.SectionTitle;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {SectionTitle.class, Title.class}, resourceType = "digitalworks/components/content/sectiontitle/v1/sectiontitle", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SectionTitleImpl implements SectionTitle, Title {
    private static final Logger LOGGER = LoggerFactory.getLogger(SectionTitleImpl.class);

    @Inject
    private Resource resource;

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String analyticsID;

    @ValueMapValue
    private String anchor;

    @ValueMapValue
    private String sectionTitle;

    @ValueMapValue
    private String pageTitle;


    @Override
    public String getPageTitle() {
        return pageTitle;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getAnalyticsID() {
        return analyticsID;
    }

    @Override
    public String getAnchor() {
        return anchor;
    }

    @Override
    public String getSectionTitle() {
        return sectionTitle;
    }
}
