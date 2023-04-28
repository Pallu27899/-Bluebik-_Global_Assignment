package com.Bankapp.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Account {
	@Id
    private Long accountId;
    private Double balance;
    

    @ManyToMany(mappedBy = "accounts")
    private List<User> users;

}
