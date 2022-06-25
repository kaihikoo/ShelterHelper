package primary.ShelterHelper.Model;



public class User {


        private String nickname;

        private String surname;

        private String name;

        private String email;

        private String password;

        public User(String nickname, String surname, String name, String email, String password) {
                this.nickname = nickname;
                this.surname = surname;
                this.name = name;
                this.email = email;
                this.password = password;
        }

        public User() {}


        public void setNickname(String nickname) {
                this.nickname = nickname;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPassword(String password) {
                if(password.length()>=8) {
                        this.password = password;
                }

        }

        public String getNickname() {
                return nickname;
        }

        public String getSurname() {
                return surname;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

        public String getPassword() {
                return password;
        }

        @Override
        public String toString() {
                return "User{" +
                        "nickname='" + nickname + '\'' +
                        ", surname='" + surname + '\'' +
                        ", name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        '}';
        }
}
