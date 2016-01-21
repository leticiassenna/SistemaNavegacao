/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.control;


/**
 *
 * @author Leticia
 */
public class Cidade {
    private final String nome;
    private final double latitude;
    private final double longitude;

    public Cidade(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
    @Override
    public String toString() {
        return "Cidade "+ getNome();
    }

    @Override
    public int hashCode() {
        return getNome().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cidade)) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        return getNome().equals(other.getNome());
    }
    
}
