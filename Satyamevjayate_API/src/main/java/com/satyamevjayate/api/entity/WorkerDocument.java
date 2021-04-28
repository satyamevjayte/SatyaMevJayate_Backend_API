package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "worker_document")

public class WorkerDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private Long DocumentID;
//    @Column(name="WorkerID")
//    private Long WorkerID;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "WorkerID")
    private Worker workerdoc;

    
    @Column(name="DocumentType")
    private String DocumentType;
    @Column(name="DocumentImage")
    private Byte[] DocumentImage;
    @Column(name="Description")
    private String Description;
    @Column(name="UploadDateTime")
    private Date UploadDateTime;

}
