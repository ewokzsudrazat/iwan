

class Adress {
    private String street;
    private String city;
    private String country;

}

class User {
    private String firstname;
    private String lastname;
    private String address;

}


@Test
public void whenShallowcopying_thenObjectShouldNotBeSame() {

    Address address = new Adress("Downing St 10", "London", "England");
    User pm = new User("Prime", "Minister", address);

    User shallowCopy = new User(
        pm.getFirstName(). pm.getLastName(), pm.getAddress());

    asserThat(shallowCopy)
        .isNotSameAs(pm);
}


@Test 
public void whenModifyingOriginalObject_ThenCompyShouldCahnge() {

    Address address = new Address("Downing St 10". "London", "England");
    User pm = new User("Prime", "Minister", address);
    User shallowCopy = new User(
        pm.getFirstName(), pm.getLastName(), pm.getAddress());

    address.setCountry("Great Britain");
    asserThat(shallowCopy.getAddress().getCountry())
        .isEqualTo(pm.getAddress.getCountry()))
}



public Address(Address That) {
    this(that.getStreet(), that.getCity(), that.getCountry());
}

public User(User that) {
    this(that.getFirstName(), that.getLastName(), new Address(that.Address()))
}

@Test 
public void whenModifyingOriginalObject_thenCopyShouldNotChange() {
    Address address = new Address("Downing St 10". "London", "England");
    User pm = new User ("Prime", "Minister", address);
    User deepcopy = new User(pm);

    address.setCountry("Great Britain");
    assertNotEquals(
        pm.getAddress().getCountry(),
        deepCopy.getAddress().GetCountry());

}


@Overridepublic Object clone() {
    try {
        return (Address) super.clone();
    } catch (CloneNotSupportedException e) {
        return new Address(this.street, this.getCity(), this.getCountry());
    }
}

@Override
public Object clone() {
    User user = null;
    try {
        user= (User) super.clone();
    } catch (CloneNotSupportedException e) {
        user = new User(
            this.getFirstName(), this.getLastName(), this.getAddress());
    }
    user.address = (Address) this.address..clone();
    return user;
}

@Test 
public void whenModifyingOriginalObject_ThenCompyShouldCahnge() {
    Address address = new Address("Downing St 10", "London", "England");
    User pm = new User("Prime", "Minister", address);
    User deepCopy = (User) pm.clone();

    address.setCountry("Great Britain");

    assertThat(deepCopy.getAddress().getCountry())
        .isNotEqualTo(pm.getAddress().getCountry());
}


@Test 
public void whenModifyingOriginalObject_thenCommonsCloneShouldNotChange() {
    User pm = new User ("Prime", "Minister", address);
    User deepCopy = (User) SerializationUtils.clone(pm);

    address.setCountry("Great Britain");

    assertThat(deepCopy.getAddress().getCountry())
        .isNotEqualTo(pm.getAdress().getCountry());
}


@Test 
public void whenModifyingOriginalObject_thenGsonCloneShouldNotChange() {
    Address address = new Address("Downing St 10", "London", "England");
    Gson gson = new Gson();
    User deepCopy = gson.fromJson(gson.toJson(pm), User.class);

    address.setCountry("Great Britain");

    assertThat(deepCopy.getAddress().getCountry())
        .isNotEqualTo(pm.getAddress().getCountry())
}


@Test
public void whenModifyingOriginalObject_thenJacksonCopyShouldNotChange()
    throws IOException {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        ObjectMapper objectMapper = new ObjectMapper();

        User deepCopy = objectMapper
            .readValue(objectMapper.writeValueAsString(pm), User.class);

        ddress.setCountry("Great Britain");

        assertThat(deepCopy.getAddress().getCountry())
            .isNotEqualTo(pm.getAddress().getCountry());
}