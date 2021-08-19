package br.com.rabbitbank.rabbitbank.model;

public enum PermissionType {

    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private String code;

    private PermissionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
