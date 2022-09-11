package pl.sdacademy.unit.test.advance.exercises.mockito.user;

public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserService(final UserRepository userRepository, final UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public User getUserById(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(String firstname, String lastname) {
        UserDto userDto = new UserDto(firstname, lastname);
        if (userValidator.isUserValid(userDto)) {
            User user = userRepository.addUser(userDto);
            user.setLastName(user.getLastName().toUpperCase());
        return user;
        }
        throw new IllegalArgumentException("User is invalid");
    }
}