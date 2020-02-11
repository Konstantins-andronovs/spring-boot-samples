package com.example.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MemberRepository memberRepository) {
        return args -> {
            Member member = new Member();
            member.setFirstName("Robert");
            member.setLastName("Mondovi");
            member.setAge(23);
            member.setGender("male");

            memberRepository.save(member);

            Optional<Member> optionalMember = memberRepository.findByFirstName("Robert");

            if (optionalMember.isPresent()) {
                System.out.println("Member" + member);
            }
        };
    }

}
