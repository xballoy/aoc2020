package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day7.Rule;
import com.xballoy.aoc.challenge.day7.RuleParser;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day7 implements Day {

    private final Graph<String, DefaultEdge> graph;

    public Day7(final InputSupplier inputSupplier) {
        RuleParser ruleParser = new RuleParser();
        final List<Rule> rules = inputSupplier.get()
            .map(ruleParser)
            .collect(Collectors.toList());

        graph = new DirectedMultigraph<>(DefaultEdge.class);
        for (Rule rule : rules) {
            graph.addVertex(rule.getBagType());
        }

        for (Rule rule : rules) {
            final String bagType = rule.getBagType();
            rule.getContent()
                .forEach((key, value) -> {
                    for (int i = 0; i < value; i++) {
                        graph.addEdge(bagType, key);
                    }
                });
        }
    }

    @Override
    public int part1() {
        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);

        return (int) graph.vertexSet().stream().map(it -> dijkstraAlg.getPath(it, "shiny gold"))
            .filter(Objects::nonNull)
            .filter(it -> !"shiny gold".equals(it.getStartVertex()))
            .count();
    }

    @Override
    public int part2() {
        return 0;
    }
}
