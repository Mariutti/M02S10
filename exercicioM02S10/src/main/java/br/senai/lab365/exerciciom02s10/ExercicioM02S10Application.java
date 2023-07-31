package br.senai.lab365.exerciciom02s10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicioM02S10Application {

    public static void main(String[] args) {
        SpringApplication.run(ExercicioM02S10Application.class, args);
    }

}

//TODO
// A ideia do projeto é que tenha uma página listando todos os pets disponíveis para adoção. Para cadastrar um pet ou
// adotar, deverá ser feito um cadastro de usuário para autenticação. Após adoção, o pet não deverá mais aparecer na
// listagem.
// Nesse momento vamos nos concentrar nas operações básicas, como cadastro de usuário e pets, assim como a listagem dos
// pets.
// O usuário deverá ter pelo menos um papel (role) associado, sendo:
// ROLE_TUTOR
// ROLE_ADOTANTE
// Ao fim desse exercício você deverá ter uma rota onde:
// Cadastre um usuário
// Cadastre um pet
// Liste os pets cadastrados