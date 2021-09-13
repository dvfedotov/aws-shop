package ru.dfed.aws.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "shopping_cart")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "revision_number", nullable = false)
    private String revisionNumber;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToOne
    @JoinColumn(unique = true)
    private Customer customer;

    @OneToMany(mappedBy = "shoppingCart")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<CartLine> cartLineIds = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public ShoppingCart revisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public ShoppingCart orderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Set<CartLine> getCartLineIds() {
        return cartLineIds;
    }

    public void setCartLineIds(Set<CartLine> cartLines) {
        this.cartLineIds = cartLines;
    }

    public ShoppingCart cartLineIds(Set<CartLine> cartLines) {
        this.cartLineIds = cartLines;
        return this;
    }

    public ShoppingCart addCartLineId(CartLine cartLine) {
        this.cartLineIds.add(cartLine);
        cartLine.setShoppingCart(this);
        return this;
    }

    public ShoppingCart removeCartLineId(CartLine cartLine) {
        this.cartLineIds.remove(cartLine);
        cartLine.setShoppingCart(null);
        return this;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShoppingCart)) {
            return false;
        }
        return id != null && id.equals(((ShoppingCart) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ShoppingCart{" +
            "id=" + getId() +
            ", revisionNumber='" + getRevisionNumber() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            "}";
    }
}
