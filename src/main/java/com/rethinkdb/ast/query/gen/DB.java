package com.rethinkdb.ast.query.gen;

import java.util.List;
import java.util.Map;

import com.rethinkdb.ast.helper.Arguments;
import com.rethinkdb.ast.helper.OptionalArguments;
import com.rethinkdb.ast.query.RqlQuery;
import com.rethinkdb.model.Durability;
import com.rethinkdb.proto.Q2L;

// extends RqlTopLevelQuery
public class DB extends RqlQuery {

    public DB(List<Object> args, java.util.Map<String, Object> optionalArgs) {
        super(Q2L.Term.TermType.DB, args, optionalArgs);
    }

    public TableCreate tableCreate(String tableName) {
        return tableCreate(tableName, null, null);
    }

    /**
     * Create table with tableName, primaryKey, Durability on a specific dataCenter.
     *
     * @param tableName  tableName (mandatory)
     * @param primaryKey primary key (leave null for default)
     * @param durability durability  (leave null for default)
     */
    public TableCreate tableCreate(String tableName, String primaryKey, Durability durability) {
        return tableCreate(tableName, primaryKey, durability, null, null);
    }

    /**
     * Create table with tableName, primaryKey, Durability, replica mapping, and primary replica tag on a specific dataCenter.
     *
     * @param tableName  tableName (mandatory)
     * @param primaryKey primary key (leave null for default)
     * @param durability durability  (leave null for default)
     * @param replicas replicas (leave null for default)
     * @param primaryReplicaTag primaryReplicaTag  (leave null for default)
     */
    public TableCreate tableCreate(String tableName, String primaryKey, Durability durability, Map<String, Integer> replicas, String primaryReplicaTag) {
        OptionalArguments optionalArguments = new OptionalArguments()
                .with("primary_key", primaryKey)
                .with("durability", durability == null ? null : durability.toString())
                .with("replicas", replicas)
                .with("primary_replica_tag", primaryReplicaTag);

        return new TableCreate(this, new Arguments(tableName), optionalArguments);
    }

    /**
     * drop table
     *
     * @param tableName table name
     */
    public TableDrop tableDrop(String tableName) {
        return new TableDrop(this, new Arguments(tableName), null);
    }

    /**
     * list tables
     */
    public TableList tableList() {
        return new TableList(this, null, null);

    }

}
        