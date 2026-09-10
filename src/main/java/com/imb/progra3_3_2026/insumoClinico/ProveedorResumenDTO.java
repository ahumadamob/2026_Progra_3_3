package com.imb.progra3_3_2026.insumoClinico;

public class ProveedorResumenDTO {

    private Long id;
    private String razonSocial;
    private String rubro;

    public ProveedorResumenDTO() {}

    public ProveedorResumenDTO(Long id, String razonSocial, String rubro) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.rubro = rubro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
}
