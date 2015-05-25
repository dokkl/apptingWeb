package com.hoon.appting.repository.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDelivery is a Querydsl query type for Delivery
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDelivery extends EntityPathBase<Delivery> {

    private static final long serialVersionUID = 897718333;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QDelivery delivery = new QDelivery("delivery");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final QUser user;

    public QDelivery(String variable) {
        this(Delivery.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QDelivery(Path<? extends Delivery> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDelivery(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDelivery(PathMetadata<?> metadata, PathInits inits) {
        this(Delivery.class, metadata, inits);
    }

    public QDelivery(Class<? extends Delivery> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

