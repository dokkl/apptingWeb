package com.hoon.appting.repository.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -317229932;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QUser user = new QUser("user");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QUserManager userManager;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QUser(Path<? extends User> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userManager = inits.isInitialized("userManager") ? new QUserManager(forProperty("userManager")) : null;
    }

}

