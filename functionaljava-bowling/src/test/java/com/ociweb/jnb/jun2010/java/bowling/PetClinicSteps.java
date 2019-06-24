package com.ociweb.jnb.jun2010.java.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.scenario.annotations.BeforeScenario;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import org.springframework.util.SerializationUtils;

public class PetClinicSteps extends Steps {

  private Vet vet;
  private Vet other;

  @BeforeScenario
  public void createVet() {
	  vet = new Vet();
	  other = new Vet();
  }  
  
  @Given("a vet whose first name is $firstName")
  public void vetFirstNameIs(String firstName) {
	  vet.setFirstName(firstName);		  
  }
  
  @Given("the last name is $lastName")
  public void vetLastNameIs(String lastName) {
	  vet.setLastName(lastName);		  
  }
  
  @Given("the id is $id")
  public void vetIdIs(Integer id) {
	  vet.setId(id);		  
  }
  
  @When("vet is serialized and then deserialized")
  public void vetIsSerializedThenDeserialized() {
	  other = (Vet) SerializationUtils
              .deserialize(SerializationUtils.serialize(vet));
  }
  
  @Then("the first name should be $firstName")
  public void vetFirstNameShouldbe(String firstName) {
	  assertThat(other.getFirstName()).isEqualTo(firstName);

  }
  
  @Then("the last name should be $lastName")
  public void vetLastNameShouldbe(String lastName) {
	  assertThat(other.getLastName()).isEqualTo(lastName);
  }
  
  @Then("the id should be $id")
  public void vetIdShouldbe(Integer id) {
	  assertThat(other.getId()).isEqualTo(id);
  }

}
