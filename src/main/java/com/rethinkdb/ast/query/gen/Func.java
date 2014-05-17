package com.rethinkdb.ast.query.gen;

import com.rethinkdb.ast.Arguments;
import com.rethinkdb.ast.RqlFunction;
import com.rethinkdb.ast.query.RqlQuery;
import com.rethinkdb.ast.query.RqlUtil;
import com.rethinkdb.proto.Q2L;

import java.util.List;

// extends RqlQuery
public class Func extends RqlQuery {

    public Func(RqlFunction function) {
        super(
                Q2L.Term.TermType.FUNC,
                new Arguments(
                        new MakeArray(new Arguments(1), null),
                        RqlUtil.toRqlQuery(function.apply(new Var(new Arguments(1), null)))
                ),
                null
        );
    }
}
        