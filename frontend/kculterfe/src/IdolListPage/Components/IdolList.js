import React, { useEffect, useState } from 'react';
import './IdolList.css';
import IdolCard from './IdolCard.js';
import IdolSearchBar from './IdolSearchBar';
import { getKpopList } from './container/GetKpopListData';

function IdolList({}) {
	const [search, setSearch] = useState("");
	const onChange = (e) => {
		setSearch(e.target.value)
	}

	const [data, setData] = useState([]);
	useEffect(() => {
		getKpopList()
		.then(resData => {
			setData(resData)
		})
		.catch(err => {
			console.log(err);
		});
		console.log(data);
	}, []);
	const filterTitle = data.filter((p) => {
		return p.name.replace(" ", "").toLocaleLowerCase().includes(search.toLocaleLowerCase());
	});
	return (
		<div className="IdolListBody">
			<div className="IdolSearchBar">
				<IdolSearchBar value={search} onChange={onChange} />
			</div>
			<div className="CardContainer">
				{ filterTitle.map(idolcard => 
				<div className="CardDiv">
					<IdolCard
					id={idolcard.keyNum}
					key={idolcard.keyNum}
					path_photo={idolcard.fileUrl}
					title={idolcard.name}
					num_like={idolcard.likeCount}
					num_spot={idolcard.likeCount}
					path_map={idolcard.path_map}
					explain={idolcard.explain}
					/>
				</div>) }
			</div>
		</div>
	)
}

export default IdolList