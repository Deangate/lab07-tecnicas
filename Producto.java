package com.tienda.inventario.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Producto {

    private Long id;
    private String sku;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private int stockActual;
    private int stockMinimo;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public Producto() {
        this.activo = true;
        this.stockActual = 0;
        this.stockMinimo = 0;
        this.precioCompra = BigDecimal.ZERO;
        this.precioVenta = BigDecimal.ZERO;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Producto(
            String sku,
            String nombre,
            String descripcion,
            Categoria categoria,
            BigDecimal precioCompra,
            BigDecimal precioVenta,
            int stockActual,
            int stockMinimo
    ) {
        this();
        setSku(sku);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecioCompra(precioCompra);
        setPrecioVenta(precioVenta);
        setStockActual(stockActual);
        setStockMinimo(stockMinimo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku != null ? sku.trim() : null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : null;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra != null ? precioCompra : BigDecimal.ZERO;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta != null ? precioVenta : BigDecimal.ZERO;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        if (stockActual < 0) {
            throw new IllegalArgumentException("El stock actual no puede ser negativo.");
        }
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        if (stockMinimo < 0) {
            throw new IllegalArgumentException("El stock mínimo no puede ser negativo.");
        }
        this.stockMinimo = stockMinimo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        if (id != null && producto.id != null) {
            return Objects.equals(id, producto.id);
        }
        return Objects.equals(sku, producto.sku);
    }

    @Override
    public int hashCode() {
        return id != null ? Objects.hash(id) : Objects.hash(sku);
    }
}