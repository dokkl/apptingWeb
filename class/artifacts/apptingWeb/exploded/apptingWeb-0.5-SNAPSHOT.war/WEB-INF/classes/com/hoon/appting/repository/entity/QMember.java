package com.hoon.appting.repository.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -157022941;

    public static final QMember member = new QMember("member1");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath birthday = createString("birthday");

    public final StringPath bloodType = createString("bloodType");

    public final DateTimePath<java.util.Date> createAt = createDateTime("createAt", java.util.Date.class);

    public final StringPath deviceRegId = createString("deviceRegId");

    public final StringPath drinkAndSmoke = createString("drinkAndSmoke");

    public final StringPath firstPoint = createString("firstPoint");

    public final StringPath hobby = createString("hobby");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idealType = createString("idealType");

    public final StringPath image1 = createString("image1");

    public final StringPath image2 = createString("image2");

    public final StringPath image3 = createString("image3");

    public final StringPath image4 = createString("image4");

    public final StringPath job = createString("job");

    public final StringPath kakaoId = createString("kakaoId");

    public final StringPath mail = createString("mail");

    public final StringPath myAppeal = createString("myAppeal");

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath phoneAuth = createString("phoneAuth");

    public final StringPath religion = createString("religion");

    public final StringPath selfIntroduction = createString("selfIntroduction");

    public final StringPath sex = createString("sex");

    public final DateTimePath<java.util.Date> updateAt = createDateTime("updateAt", java.util.Date.class);

    public final StringPath wantDate = createString("wantDate");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QMember(Path<? extends Member> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata<?> metadata) {
        super(Member.class, metadata);
    }

}

