package com.project.login.model.enun;

    public enum UserStatus {

        PENDENTE("pendente"),
        ATIVO("ativo"),
        INATIVO("inativo"),
        BANIDO("banido");

        private final String description;

        UserStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }


