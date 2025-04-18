package com.vti.blog_app01.entity;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CommentIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object o) {
        var comment = (Comment) o;
        var hql = "SELECT COUNT(*) FROM Comment WHERE status = :status";
        var count = session.createSelectionQuery(hql,Long.class).setParameter("status",comment.getStatus()).uniqueResult();

        return comment.getStatus().toString().charAt(0) + "-" + (count + 1);
    }
}
