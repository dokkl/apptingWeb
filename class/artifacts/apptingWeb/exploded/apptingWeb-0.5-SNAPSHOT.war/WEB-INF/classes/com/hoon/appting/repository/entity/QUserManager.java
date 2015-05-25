package com.hoon.appting.repository.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserManager is a Querydsl query type for UserManager
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserManager extends EntityPathBase<UserManager> {

    private static final long serialVersionUID = 646816889;

    public static final QUserManager userManager = new QUserManager("userManager");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<User, QUser> users = this.<User, QUser>createList("users", User.class, QUser.class, PathInits.DIRECT);

    public QUserManager(String variable) {
        super(UserManager.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QUserManager(Path<? extends UserManager> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QUserManager(PathMetadata<?> metadata) {
        super(UserManager.class, metadata);
    }

}

