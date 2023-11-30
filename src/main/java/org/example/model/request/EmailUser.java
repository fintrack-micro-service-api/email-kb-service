package org.example.model.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.request.EmailUserDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name="email")
    private String email;
    @Column(name="count")
    private Integer count;
    @Column(name = "date")
    private LocalDateTime dateTime;


    public EmailUserDto toDto(){
        return new EmailUserDto(this.id,this.email,this.count);
    }
}
