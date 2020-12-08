package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day7.Rule;
import com.xballoy.aoc.challenge.day7.RuleParser;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day7 implements Day {

    private static final String SHINY_GOLD = "shiny gold";
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

        return (int) graph.vertexSet().stream().map(it -> dijkstraAlg.getPath(it, SHINY_GOLD))
            .filter(Objects::nonNull)
            .filter(it -> !SHINY_GOLD.equals(it.getStartVertex()))
            .count();
    }

    @Override
    public int part2() {
        return getNumberOfBags(SHINY_GOLD);
    }

    private int getNumberOfBags(final String vertex) {
        final List<String> children = Graphs.successorListOf(graph, vertex);
        if (children.isEmpty()) {
            return 0;
        }

        return children.stream()
            .map(this::getNumberOfBags)
            .reduce(children.size(), Integer::sum);
    }

}
