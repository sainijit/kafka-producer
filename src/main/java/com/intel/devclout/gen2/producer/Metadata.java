package com.intel.devclout.gen2.producer;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;

public class Metadata {

	private String compute;
	private String cpu;
	private String gen;
	private String variant;
	private String type;
	private String mountPath;
	private String entryPoint;
	private String port;
	private String containerName;
	private Image image;
	private Map<String, String> additionalConfig;

	public Map<String, String> getAdditionalConfig() {
		return additionalConfig;
	}

	public void setAdditionalConfig(Map<String, String> additionalConfig) {
		this.additionalConfig = additionalConfig;
	}
	
	private String comparisonId;
	private String deploymentId;

	public String getComparisonId() {
		return comparisonId;
	}

	public void setComparisonId(String comparisonId) {
		this.comparisonId = comparisonId;
	}
	
	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	
	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	
	public String getCompute() {
		return compute;
	}

	public void setCompute(String compute) {
		this.compute = compute;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}


	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	private String projectDescription;

	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	private String deploymentName;

	public String getDeploymentName() {
		return this.deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	public String getNameSpace(String userName) {
		// return userName + "-" + this.NAME_SPACE;
		return userName;
	}
	public Integer containerOrder;
	
	public Integer getContainerOrder() {
		return containerOrder;
	}

	public void setContainerOrder(Integer containerOrder) {
		this.containerOrder = containerOrder;
	}

	public String getMountPath() {
		return mountPath;
	}

	public void setMountPath(String mountPath) {
		this.mountPath = mountPath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}



	public String getRandomString() {
		final byte[] array = new byte[7]; // length is bounded by 7
		new Random().nextBytes(array);
		return new String(array, Charset.forName("UTF-8"));
	}

	@Override
	public String toString() {
		return "Metadata [compute=" + compute + ", cpu=" + cpu + ", gen=" + gen + ", variant=" + variant + ", type=" + type + ", mountPath="
				+ mountPath + ", entryPoint=" + entryPoint + ", port=" + port + ", additionalConfig=" + additionalConfig
				+ ", projectDescription=" + projectDescription + ", deploymentName=" + deploymentName + ", containerName=" + containerName + ", image=" + image +"]";
	}

	

}
