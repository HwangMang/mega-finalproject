package com.project.bokduck.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;
import net.minidev.json.annotate.JsonIgnore;
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
@SuperBuilder
@DynamicUpdate
@DiscriminatorValue("COMMUNITY")
public class Community extends Post{

    @Enumerated(EnumType.STRING)
    private CommunityCategory communityCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY)
    private List<CommentCommunity> commentCommunity;

}