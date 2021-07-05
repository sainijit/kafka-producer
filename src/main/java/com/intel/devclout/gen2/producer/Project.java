package com.intel.devclout.gen2.producer;

import java.util.ArrayList;

/**
 * @author sainijit
 */
public class Project {
    private ArrayList<Metadata> metadata = new ArrayList<Metadata>();
    private boolean dirtyFlagValue;
    private String applicationName;
    private Image image;
    private String pvcName;

    public String getPvcName() {
        return pvcName;
    }

    public void setPvcName(String pvcName) {
        this.pvcName = pvcName;
    }

    public boolean getDirtyFlagValue() {
        return dirtyFlagValue;
    }

    public void setDirtyFlagValue(boolean dirtyFlagValue) {
        this.dirtyFlagValue = dirtyFlagValue;
    }


    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public ArrayList<Metadata> getMetadata() {

        return metadata;
    }

    public void setMetadata(ArrayList<Metadata> metadata) {
        this.metadata = metadata;
    }

    public Image getImage() {
        if (image == null) {
            image = new Image();
        }
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Project [metadata=" + metadata + "applicationName="+ applicationName +"dirtyFlagValue="+ dirtyFlagValue + "Image=" + image + "pvcName=" + pvcName +"]" ;
    }



}

