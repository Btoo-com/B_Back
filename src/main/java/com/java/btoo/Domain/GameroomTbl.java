package com.java.btoo.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameroomTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;
    private String room_name;
    private long host_id;
    @CreationTimestamp
    @Column(name = "ins_date")
    private LocalDateTime insDate;

    public GameroomTbl( String room_name, long host_id){

        this.room_name=room_name;
        this.host_id=host_id;
    }
}
