package entitys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
@NamedQueries({
        @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
        @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido"),
        @NamedQuery(name = "Pedido.findByFechapedido", query = "SELECT p FROM Pedido p WHERE p.fechapedido = :fechapedido"),
        @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total"),
        @NamedQuery(name = "Pedido.findByEstatusPedido", query = "SELECT p FROM Pedido p WHERE p.estatusPedido = :estatusPedido")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpedido")
    private Integer idpedido;
    @Column(name = "fechapedido")
    @Temporal(TemporalType.DATE)
    private Date fechapedido;
    @Column(name = "total")
    private Integer total;
    @Column(name = "estatusPedido")
    private String estatusPedido;
    @JoinColumn(name = "idCliente", referencedColumnName = "telefono")
    @ManyToOne
    private Cliente idCliente;
    @OneToMany(mappedBy = "idpedido")
    private Collection<Productospedido> productospedidoCollection;

    public Pedido() {
    }

    public Pedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(Date fechapedido) {
        this.fechapedido = fechapedido;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getEstatusPedido() {
        return estatusPedido;
    }

    public void setEstatusPedido(String estatusPedido) {
        this.estatusPedido = estatusPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Collection<Productospedido> getProductospedidoCollection() {
        return productospedidoCollection;
    }

    public void setProductospedidoCollection(Collection<Productospedido> productospedidoCollection) {
        this.productospedidoCollection = productospedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Pedido[ idpedido=" + idpedido + " ]";
    }

}
