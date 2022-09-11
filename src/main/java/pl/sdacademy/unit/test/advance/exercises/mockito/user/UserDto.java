package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import java.util.Objects;

public class UserDto {
    private String firstname;
    private String lastname;

    public UserDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(firstname,userDto.firstname) && Objects.equals(lastname,userDto.lastname);
    }
}
