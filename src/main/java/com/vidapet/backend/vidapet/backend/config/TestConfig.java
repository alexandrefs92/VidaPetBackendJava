package com.vidapet.backend.vidapet.backend.config;

import com.vidapet.backend.vidapet.backend.enums.RoleName;
import com.vidapet.backend.vidapet.backend.enums.TipoPessoa;
import com.vidapet.backend.vidapet.backend.models.*;
import com.vidapet.backend.vidapet.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {
       /* UserModel u1 = new UserModel();
        u1.setEmail("alexandre@gmail.com");
        u1.setUsername("alexandre");
        u1.setPassword(new BCryptPasswordEncoder().encode("senha123"));

        userRepository.save(u1);

        RoleModel r1 = new RoleModel();
        r1.setRoleName(RoleName.ROLE_ADMIN);

        r1 = roleRepository.save(r1);

        PessoaModel p1 = new PessoaModel();
        p1.setTipoPessoa(TipoPessoa.PESSOA_FISICA);
        p1.setDataNascimento(Instant.now());
        p1.setEmail("alexandre@gmail.com");
        p1.setNome("Alexandre");

        EstadoModel estado1 = new EstadoModel();
        estado1.setSigla("SC");
        estado1 = estadoRepository.save(estado1);


        EnderecoModel e1 = new EnderecoModel();
        e1.setEstadoModel(estado1);
        e1.setLogradouro("Teste rua 1");
        e1 = enderecoRepository.save(e1);

        p1.setEndereco(e1);

        pessoaRepository.save(p1);*/

    }
}
