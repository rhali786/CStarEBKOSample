package com.travelers.bi.om.uguide.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import com.travelers.bi.om.uguide.sort.SelectItemComparator;
import com.travelers.bi.om.uguide.domain.IndustryEdge;
import com.travelers.bi.om.uguide.domain.TriggerCategory;
import com.travelers.bi.om.uguide.domain.UnderwritingTriggers;

@Named("underwritingTriggersView")
@RequestScoped
public class UnderwritingTriggersView {

    private List<SelectItem> options = null;
    private List<SelectItem> programOptions = null;
    private String FBU = null;
    private boolean usePropertyFormatting = false;
    private boolean isProgramTriggersReadable = false;
    private boolean isProgramTriggersView = false;
    private boolean isGlobalMsgReadable = false;
    public boolean isProgramTriggersView() {
		return isProgramTriggersView;
	}

	public void setProgramTriggersView(boolean isProgramTriggersView) {
		this.isProgramTriggersView = isProgramTriggersView;
	}

	private boolean isTriggersReadable = false;
    private UnderwritingTriggers underwritingTriggers = null;
    private List<IndustryEdge> industryEdges;
	private List<TriggerCategory> CNSProgramTriggers;
	
    public UnderwritingTriggersView() {
        // default constructor
    }
    
    public List<TriggerCategory> getCNSProgramTriggers() {
        return CNSProgramTriggers;
    }

    public List<SelectItem> getOptions() {
        if (options == null) {
            this.buildCategoryDropdown();
        }
        return options;
    }

    public void setOptions(List<SelectItem> options) {
        this.options = options;
    }

    public void setProgramOptions(List<SelectItem> programOptions) {
        this.programOptions = programOptions;
    }

    public List<SelectItem> getProgramOptions() {
        if (programOptions == null) {
            this.buildProgramCategoryDropdown();
        }

        return programOptions;
    }

    public List<TriggerCategory> getTriggerCategories() {
        List<TriggerCategory> triggerCategories = null;
        if(underwritingTriggers != null){
            triggerCategories = underwritingTriggers.getTriggerCategories();
        }
        return triggerCategories;
    }

    public void buildCategoryDropdown() {

        options = new ArrayList<SelectItem>();
        // SelectItemGroup group = null;
        // List<SelectItem> subItems = null;

        if (this.getTriggerCategories() != null) {
            for (TriggerCategory thisCategory : this.getTriggerCategories())

                if (thisCategory.getSubCategories() == null) {
                    options.add(new SelectItem(thisCategory.getTriggerCategoryId(), thisCategory
                            .getRuleGroupDescription()));
                } else {
                    SelectItemGroup group = new SelectItemGroup(thisCategory.getRuleGroupDescription());
                    List<SelectItem> subItems = new ArrayList<SelectItem>();

                    for (TriggerCategory subcategory : thisCategory.getSubCategories()) {

                        subItems.add(new SelectItem(subcategory.getTriggerCategoryId(), subcategory
                                .getRuleGroupDescription()));
                    }

                    group.setSelectItems(subItems.toArray(new SelectItem[subItems.size()]));
                    options.add(group);
                }
        }

    }

    public void buildProgramCategoryDropdown() {

        programOptions = new ArrayList<SelectItem>();
        if (this.getFBU().equalsIgnoreCase("CNS")) {
        	if (this.getCNSProgramTriggers() != null) {
        		for (TriggerCategory trigCat : this.getCNSProgramTriggers())
        			programOptions.add(new SelectItem(trigCat.getTriggerCategoryId(), trigCat.getRuleGroupDescription()));
        	}
        }
        else{
        if (this.getIndustryEdges() != null) {
            for (IndustryEdge edge : this.getIndustryEdges())
                programOptions.add(new SelectItem(edge.getCode(), edge.getDescription()));
        }
        }

        Collections.sort(programOptions, new SelectItemComparator());
        
    }

    public void setUnderwritingTriggers(UnderwritingTriggers underwritingTriggers) {
        this.underwritingTriggers = underwritingTriggers;
    }

    public TriggerTopicViewConfig getTriggerTopicViewConfig(String topicName) {
        return TriggerTopicViewConfig.getTopicViewConfigByName(topicName);
    }

    public ProgramTriggerViewConfig getFinBuConfigByCd(String code) {
        return ProgramTriggerViewConfig.getFinBuConfigByCd(code);
    }

    public String getFBU() {
        return FBU;
    }

    public void setFBU(String fbu) {
        FBU = fbu;
    }

    public Boolean isUsePropertyFormatting() {

        List<String> specialProp = new ArrayList<String>();

        Collections.addAll(specialProp, "CAG", "TEC", "GLU", "PUB", "1PC");
        this.setUsePropertyFormatting(specialProp.contains(this.getFBU()));

        return usePropertyFormatting;
    }

    public void setUsePropertyFormatting(Boolean usePropertyFormatting) {
        this.usePropertyFormatting = usePropertyFormatting;
    }

    public UnderwritingTriggers getUnderwritingTriggers() {
        return underwritingTriggers;
    }

    public List<IndustryEdge> getIndustryEdges() {
        return industryEdges;
    }

    public void setIndustryEdges(List<IndustryEdge> industryEdges) {
        this.industryEdges = industryEdges;
    }

    public Boolean getUsePropertyFormatting() {
        return usePropertyFormatting;
    }

    public boolean isProgramTriggersReadable() {
        return isProgramTriggersReadable;
    }

    public void setProgramTriggersReadable(boolean isProgramTriggersReadable) {
        this.isProgramTriggersReadable = isProgramTriggersReadable;
    }

    public boolean isTriggersReadable() {
        return isTriggersReadable;
    }

    public void setTriggersReadable(boolean isTriggersReadable) {
        this.isTriggersReadable = isTriggersReadable;
    }

    
    public String programTriggersVisibility() {
    	
    	String triggerGridStyle = "none";
    	
    	if (this.isProgramTriggersView) {
    		triggerGridStyle = "block";
    	} 
    	
    	return triggerGridStyle;
    }
    
	public void setCNSProgramTriggers(List<TriggerCategory> cnsProgramTriggers) {

		this.CNSProgramTriggers = cnsProgramTriggers;
		
	}

	public boolean isGlobalMsgReadable() {
		return isGlobalMsgReadable;
	}

	public void setGlobalMsgReadable(boolean isGlobalMsgReadable) {
		this.isGlobalMsgReadable = isGlobalMsgReadable;
	}
	

}
