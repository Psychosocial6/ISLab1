import React, {useEffect, useMemo, useState} from 'react';
import {api} from '../../api/api';
import PersonModal from '../../components/PersonModal/PersonModal';
import './VisualizationPage.css';

const SVG_SIZE = 600;
const HALF = SVG_SIZE / 2;
const PADDING = 40;
const USABLE_RADIUS = HALF - PADDING;

export default function VisualizationPage({personsEvent}) {
    const [persons, setPersons] = useState([]);
    const [selectedPerson, setSelectedPerson] = useState(null);
    const [hovered, setHovered] = useState(null);

    const loadPersons = async () => {
        try {
            const res = await api.getAllPersonsRaw();
            setPersons(res.content || []);
        } catch (err) {
        }
    };

    useEffect(() => {
        loadPersons();
    }, []);

    useEffect(() => {
        if (personsEvent) {
            loadPersons();
        }
    }, [personsEvent]);

    const {scale, maxVal} = useMemo(() => {
        let max = 50;
        persons.forEach(p => {
            if (p.coordinates) {
                max = Math.max(max, Math.abs(p.coordinates.x), Math.abs(p.coordinates.y));
            }
        });
        const roundedMax = Math.ceil(max);
        return {
            maxVal: roundedMax,
            scale: USABLE_RADIUS / roundedMax
        };
    }, [persons]);

    return (
        <div className="vis-page">
            <div className="vis-header">
                <h2>Visualization by coordinates</h2>
                <span className="vis-hint">
                    Current range: <strong>[-{maxVal}, +{maxVal}]</strong>. Click to view or edit Person.
                </span>
            </div>

            <div className="svg-wrapper">
                <svg width={SVG_SIZE} height={SVG_SIZE} viewBox={`0 0 ${SVG_SIZE} ${SVG_SIZE}`}>
                    <line x1={0} y1={HALF} x2={SVG_SIZE} y2={HALF} stroke="#94a3b8" strokeWidth="1.5"/>
                    <line x1={HALF} y1={0} x2={HALF} y2={SVG_SIZE} stroke="#94a3b8" strokeWidth="1.5"/>
                    <line x1={HALF + USABLE_RADIUS} y1={HALF - 5} x2={HALF + USABLE_RADIUS} y2={HALF + 5}
                          stroke="#64748b"/>
                    <text x={HALF + USABLE_RADIUS - 10} y={HALF + 18} fill="#64748b" fontSize="10">+{maxVal}</text>
                    <line x1={HALF - USABLE_RADIUS} y1={HALF - 5} x2={HALF - USABLE_RADIUS} y2={HALF + 5}
                          stroke="#64748b"/>
                    <text x={HALF - USABLE_RADIUS - 10} y={HALF + 18} fill="#64748b" fontSize="10">-{maxVal}</text>
                    <line x1={HALF - 5} y1={HALF - USABLE_RADIUS} x2={HALF + 5} y2={HALF - USABLE_RADIUS}
                          stroke="#64748b"/>
                    <text x={HALF + 8} y={HALF - USABLE_RADIUS + 4} fill="#64748b" fontSize="10">+{maxVal}</text>
                    <line x1={HALF - 5} y1={HALF + USABLE_RADIUS} x2={HALF + 5} y2={HALF + USABLE_RADIUS}
                          stroke="#64748b"/>
                    <text x={HALF + 8} y={HALF + USABLE_RADIUS + 4} fill="#64748b" fontSize="10">-{maxVal}</text>
                    <text x={SVG_SIZE - 15} y={HALF - 10} fill="#334155" fontSize="12" fontWeight="bold">X</text>
                    <text x={HALF + 10} y={15} fill="#334155" fontSize="12" fontWeight="bold">Y</text>
                    <text x={HALF + 6} y={HALF + 16} fill="#94a3b8" fontSize="10">(0,0)</text>
                    {persons.map(p => {
                        if (!p.coordinates) return null;
                        const cx = HALF + (p.coordinates.x * scale);
                        const cy = HALF - (p.coordinates.y * scale);
                        return (
                            <g key={p.id}>
                                <circle
                                    cx={cx}
                                    cy={cy}
                                    r={5}
                                    className="person-dot"
                                    onClick={() => setSelectedPerson(p)}
                                    onMouseEnter={() => setHovered(p)}
                                    onMouseLeave={() => setHovered(null)}
                                />
                                <text x={cx + 7} y={cy + 4} fontSize="11" fill="#0f172a">
                                    {p.name}
                                </text>
                            </g>
                        );
                    })}
                </svg>

                {hovered && (
                    <div className="vis-tooltip">
                        <strong>{hovered.name}</strong> (ID: {hovered.id})<br/>
                        X: {hovered.coordinates?.x}, Y: {hovered.coordinates?.y}<br/>
                    </div>
                )}
            </div>

            {selectedPerson && (
                <PersonModal
                    person={selectedPerson}
                    onClose={() => setSelectedPerson(null)}
                    onSaved={loadPersons}
                />
            )}
        </div>
    );
}