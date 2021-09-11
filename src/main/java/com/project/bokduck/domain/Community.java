package com.project.bokduck.domain;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@DiscriminatorValue("COMMUNITY")
public class Community extends Post{
    @Id
    private Long id;

    @ManyToOne
    private Member communityWriter;

    @Enumerated()
    private CommunityCategory communityCategory;

    @OneToMany(mappedBy = "community" , cascade = CascadeType.ALL)
    private List<CommentCommunity> commentCommunity;

}
