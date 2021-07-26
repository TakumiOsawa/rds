package com.sample.aws.rds.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "grp", schema = "public", catalog = "sample_database")
public class Group {
    private long groupId;
    private String groupName;
    private Integer ver;
    private Timestamp lastUpdatedAt;
    private Collection<Membership> membershipsByGroupId;

    @Id
    @Column(name = "group_id", nullable = false)
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name", nullable = true, length = -1)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "ver", nullable = true)
    @Version
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @Basic
    @Column(name = "last_updated_at", nullable = true)
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId &&
                Objects.equals(groupName, group.groupName) &&
                Objects.equals(ver, group.ver) &&
                Objects.equals(lastUpdatedAt, group.lastUpdatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, groupName, ver, lastUpdatedAt);
    }

    @OneToMany(mappedBy = "grpByGroupId", cascade=CascadeType.ALL)
    public Collection<Membership> getMembershipsByGroupId() {
        return membershipsByGroupId;
    }

    public void setMembershipsByGroupId(Collection<Membership> membershipsByGroupId) {
        this.membershipsByGroupId = membershipsByGroupId;
    }
}