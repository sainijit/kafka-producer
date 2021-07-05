package com.intel.devclout.gen2.producer;

/**
 * @author sainijit
 */
public class Gen2DeploymentRequest {
    public class OpenShiftSSORequest {
        private String userName;
        private String token;
        private Project project;
        private String userId;
        private String containerName;

        public String getContainerName() {
            return containerName;
        }

        public void setContainerName(String containerName) {
            this.containerName = containerName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "OpenShiftSSORequest [userName=" + userName + ", token=" + token + ", project=" + project + ", userId="
                    + userId + "]";
        }

    }
}
