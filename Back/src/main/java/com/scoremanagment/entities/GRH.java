package com.scoremanagment.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RH")
public class GRH extends DAOUser{

}
